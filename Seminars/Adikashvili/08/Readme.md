## 1. პოლიმორფიზმი

არითმეტიკული გამოსახულება წარმოადგინეთ ხის სახით და შექმენით მონაცემთა სტრუქტურა ხის წვეროების შესანახად.

![example.png](example.png)

თითოეულ კვანძს ჰქონდეს მინიმუმ ორი მეთოდი:

- `double evaluate()` - დააბრუნოს გამოთვლილი მნიშვნელობა კვანძისთვის
- `String toString()` - დააბრუნოს სტრიქონის სახით ჩაწერილი გამოსახულება გამოთვლის გარეშე, ფრჩხილებიც დასვას. სტრიქონი უნდა მოიცავდეს კვანძის ქვეხეში არსებულ სხვა გამოსახულებებსაც, მაგალითად (1 + (2 \* 3))

დააიმპლემენტირეთ 3 სხვადასხვა გზით:
1. Node კვანძით + switch statement
2. კვანძის ინტერფეისის გამოყენებით (და არანაირი if/else + switch)
3. აბსტრაქტული Operation კლასის დამატებით, რომელიც აიმპლემენტირებს კვანძის ინტერფეისს

## 2. Swing UI (მარტივი მაგალითი)

დახატეთ ღილაკი და ლეიბლი რომელზეც ეწერება რამდენჯერ დაეჭირა ღილაკს.