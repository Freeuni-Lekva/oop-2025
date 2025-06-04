## React + Typescript

ეს სემინარი არის წინა სემინარის გაგრძელება.

წინა სემინარზე დაწერილ ბექენდის ნაწილს დაამატეთ ფრონტი და ამით გამართეთ full-stack აპლიკაცია.

* უნდა შეგვეძლოს UI-დან სერვერისთვის AJAX-ით(fetch API) მოთხოვნების გაგზავნა (ახალი ქულის დამატება, ქულების წამოღება და ჩვენება). 
* დაამატეთ გუგლით ავტორიზაცია.
  * მასწავლებელია, თუ მეილი არ შეიცავს ციფრებს.
  * მოსწავლის მეილი შეიცავს მინიმუმ 1 ციფრს.
* მოსწავლეს აჩვენეთ მისი შეფასება კრიტერიუმების მიხედვით, მასწავლებელს კი - ცხრილი საიდანაც შეუძლია მოსწავლეს შეფასება დაუმატოს.


-------------------

1. რეაქტის პროექტის გენერირება
```shell
npx create-react-app frontend --template typescript
```

2. გუგლის ავტორიზაციისთვის
```shell
npm install @react-oauth/google@latest jwt-decode

jwtDecode(credentials.credential)
GoogleLogin
googleLogout
```

3.  ბუთსთრაპი
```shell
npm install bootstrap react-bootstrap

import 'bootstrap/dist/css/bootstrap.min.css';
```