import {Grade} from "../contract/types";

export const addStudentGrade = async (grade: Grade, mail: string) => {
    console.log(`http://localhost:8080/grade/add/${mail}`, grade, mail);

    const response = await fetch(`http://localhost:8080/grade/add/${mail}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(grade),
    });

    if (!response.ok) {
        alert("grade not added");
    }
};