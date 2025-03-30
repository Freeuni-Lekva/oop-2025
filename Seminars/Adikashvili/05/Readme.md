## 1. ინტერფეისები, აბსტრაქტული კლასები

- შექმენით `interfaces.Device` ინტერფეისი `on` და `off` მეთოდებით.
- შექმენით `interfaces.Device` ინტერფეისის მემკვიდრე `interfaces.Electronic` ინტერფეისი `plugin` მეთოდით.
- შექმენით `interfaces.Phone` აბსტრაქტული კლასი აბსტრაქტული `makeCall(String number)` და არააბსრაქტული `testCall(String number)` მეთოდებით.
- `interfaces.Phone` კლასი უნდა აკეთებდეს `interfaces.Electronic` ინტერფეისის იმპლემენტაციას.
- შექმენით `interfaces.Phone` კლასის მემკვიდრე `interfaces.Mobile` კლასი და აღწერეთ მხოლოდ ერთი, ნებისმიერი მეთოდი.
- გადააკეთეთ `interfaces.Electronic` ინტერფეისი აბსტრაქტულ კლასად.

## 2. მემკვიდრეობითობა

- აღწერეთ `Parent` მშობელი და `Child` შვილობილი კლასები.
- აღწერეთ `go` მეთოდი, რომელიც არაფერს აბრუნებს და კონსოლში ბეჭდავს `go method in Parent class`.
- გადაფარეთ `go` მეთოდი `Child` კლასში, რომელიც დაბეჭდავს `go method in Child class`.
- აღწერეთ `Test` კლასი
- აღწერეთ ორი სტატიკური `invoke` მეთოდი `Test` კლასში. პირველს პარამეტრად ჰქონდეს `Parent` ხოლო მეორეს `Child` ტიპი.
- ორივე `invoke` მეთოდში გამოიძახეთ `go` მეთოდი გადმოცემული პარამეტრიდან
- აღწერეთ `Test` კლასში `main` მეთოდი და შექმენით:
    - `Parent` კლასის ობიექტი `Parent` კლასის ტიპის მითითებით
    - `Child` კლასის ობიექტი `Child` კლასის ტიპის მითითებით
    - `Parent` კლასის ობიექტი `Child` კლასის ტიპის მითითებით
    - `Child` კლასის ობიექტი `Parent` კლასის ტიპის მითითებით
    - გადაეცით ყველა მითითება `invoke` მეთოდს ცალცალკე და დააკვირდით რა დაიბეჭდება.

## 3. SOLID

- Single Responsibility - Book კლასი
- Open-closed principle - Calculator კლასი
- Liskov Substitution principle - Rectangle კლასი
- Interface Segregation - Worker ინტერფეისი
- Dependency Inversion - Database ინტერფეისი