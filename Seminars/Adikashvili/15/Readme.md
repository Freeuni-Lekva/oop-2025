## ნაკადები - სინქრონიზაციის მექანიზმები

1. Conway's Game of Life (CyclicBarrier) - სიმულაცია, სადაც გრიდზე გვაქვს n რაუნდი და ყოველი რაუნდის შემდეგ თითოეული უჯრა ცოცხლობს/კვდება იმის მიხედვით თუ რამდენი ცოცხალი მეზობელი ჰყავს
   1. ნებისმიერი უჯრედი, რომელსაც 2-ზე ნაკლები ცოცხალი მეზობელი ჰყავს კვდება underpopulation-ის გამო
   2. ნებისმიერ უჯრედი, რომელსაც 2 ან 3 ცოცხალი მეზობელი ჰყავს ცოცხლობს შემდეგ იტერაციამდე
   3. ნებისმიერი უჯრედი, რომელსაც 3-ზე მეტი ცოცხალი მეზობელი ჰყავს კვდება overpopulation-ის გამო
   4. ნებისმიერი მკვდარი უჯრედი, რომელსაც ზუსტად 3 ცოცხალი მეზობელი ჰყავს ცოცხლდება reproduction-ის გამო

2. Formula 1 (CountdownLatch) - race-ის სიმულაცია, სადაც გვყავს n მონაწილე. რბოლის დაწყებამდე საჭიროა თითოეული მონაწილე გაემზადოს და main ნაკადის სიგნალს დაუცადოს. რბოლის დაწყებისას კი main ნაკადი უცდის რბოლის დამთავრებას და ბეჭდავს TOP 3 მონაწილეს.
