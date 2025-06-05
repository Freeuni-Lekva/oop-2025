export type Role = 'LECTURER' | 'STUDENT';

export type Criterion = 'PROJECT' | 'IMPLEMENTATION' | 'TESTING' | 'CODE_REVIEW' | 'REFLECTION';

export interface User {
    email: string;
    role: Role;
}

export interface Grade {
    criterion: Criterion;
    score: number;
    comment: string;
    studentMail: string;
}