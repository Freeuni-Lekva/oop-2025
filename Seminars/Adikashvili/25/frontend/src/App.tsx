import React, {useEffect, useState} from 'react';
import {Badge, Button, Col, Container, Form, Row} from "react-bootstrap";
import {jwtDecode} from "jwt-decode";
import {GoogleLogin, googleLogout} from "@react-oauth/google";
import {Criterion, Grade, Role, User} from "./contract/types";
import {addStudentGrade} from "./data/data-requests";

function App() {
    console.log("rendered");

    // array destructurizing
    const [user, setUser] = useState<User | null>(null); // hook

    // grade state
    const [criterion, setCriterion] = useState<Criterion>('PROJECT');
    const [score, setScore] = useState<number>(0);
    const [studentMail, setStudentMail] = useState<string>('');
    const [comment, setComment] = useState<string>('');

    const handleLogin = (credentials: any): void => {
        const decoded: any = jwtDecode(credentials.credential);
        const email = decoded.email;

        const role: Role = email.match('.*[0-9].*') ? 'STUDENT' : 'LECTURER';

        const user: User = {
            email: email,
            role: role,
        };

        setUser(user);

        localStorage.setItem('user', JSON.stringify(user));
    };

    const handleLogOut = () => {
        googleLogout();
        localStorage.removeItem('user');
        setUser(null);
    };

    const addGrade = () => {
        const grade: Grade = {
            criterion,
            score,
            comment,
            studentMail,
        }

        addStudentGrade(grade, user?.email!);
    };

    useEffect(() => {
        const user: string | null = localStorage.getItem('user');
        if (user) {
            setUser(JSON.parse(user));
        }
    }, []);

    return (
        <Container className={"mt-4 border rounded p-3"}>
            {!user ? <GoogleLogin onSuccess={handleLogin}/> :

                (<div>
                    Welcome, {user.email} <Badge>{user.role}</Badge>
                    <Button className={"mx-2"} variant={"danger"} onClick={handleLogOut}>Log out</Button>

                    {
                        user.role === 'LECTURER' ? (
                            <Container>
                                <Row className={"mt-3 p-3 shadow-sm border rounded"}>
                                    <Col md={4}>
                                        <Form>
                                            <Form.Label column={true}>Student mail</Form.Label>
                                            <Form.Control
                                                type={"email"}
                                                value={studentMail}
                                                onChange={e => {
                                                    setStudentMail(e.target.value);
                                                }}
                                            >
                                            </Form.Control>
                                        </Form>
                                    </Col>
                                    <Col md={3}>
                                        <Form>
                                            <Form.Label column={true}>Student mail</Form.Label>
                                            <Form.Select
                                                value={criterion}
                                                onChange={e => {
                                                    setCriterion(e.target.value as Criterion);
                                                }}
                                            >
                                                <option value={"PROJECT"}>PROJECT</option>
                                                <option value={"IMPLEMENTATION"}>IMPLEMENTATION</option>
                                                <option value={"TESTING"}>TESTING</option>
                                                <option value={"CODE_REVIEW"}>CODE_REVIEW</option>
                                                <option value={"REFLECTION"}>REFLECTION</option>
                                            </Form.Select>
                                        </Form>
                                    </Col>
                                    <Col md={2}>
                                        <Form>
                                            <Form.Label column={true}>Score</Form.Label>
                                            <Form.Control
                                                type={"number"}
                                                value={score}
                                                onChange={e => {
                                                    setScore(Number(e.target.value));
                                                }}
                                            >
                                            </Form.Control>
                                        </Form>
                                    </Col>
                                    <Col md={3}>
                                        <Form>
                                            <Form.Label column={true}>Comment (optional)</Form.Label>
                                            <Form.Control
                                                type={"text"}
                                                value={comment}
                                                onChange={e => {
                                                    setComment(e.target.value);
                                                }}
                                            >
                                            </Form.Control>
                                        </Form>
                                    </Col>
                                    <Button className={"mt-3"} onClick={addGrade}>Add score</Button>
                                </Row>
                            </Container>
                        ) : (<Container>
                            student
                        </Container>)
                    }
                </div>)

            }
        </Container>
    );
}

export default App;
