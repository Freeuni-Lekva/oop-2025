## ბაზებთან კავშირი

### გამართვის ინსტრუქციები


- MySQL Server
    - MacOS: brew install mysql
    - Linux: sudo apt install mysql-server
- MySQL Workbench (GUI)
    - MacOS: brew install --cask mysqlworkbench
    - Linux: sudo apt install mysql-workbench
- Windows: ნახეთ PDF - [Seminar_11__MySQL_Database.pdf](Seminar_11__MySQL_Database.pdf) (სასურველია გადმოწეროთ 8.0.41 ვერსია MSI Installer)
- ვერსიის შემოწმება: mysql --version
- IntelliJ-სთან ინტეგრაცია: https://www.jetbrains.com/help/idea/mysql.html

------------------------

### ამოცანა
1. შექმენით ბაზა, რომელშიც შევინახავთ ინფორმაციას კურსების და სტუდენების შესახებ.

2. შენახვის შემდგომ, უნდა შეგვეძლოს ამ ინფორმაციის წამოღება და დაბეჭდვა.

- Students:

    - id
    - student_id
    - idnumber
    - firstname
    - lastname
    - register_date

- Courses:
    - id
    - course_id
    - course_name
    - course_credit
    - course_type

3. დაწერეთ იუნით ტესტები H2 ბაზის გამოყენებით.

------------------------

_MySQL ბაზასთან კავშირისთვის - jdbc:mysql://localhost:3306/students_db_

_MySQL Driver - com.mysql.cj.jdbc.Driver_

_H2 ბაზა: jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1_