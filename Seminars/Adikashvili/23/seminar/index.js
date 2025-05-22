var request = new XMLHttpRequest();

const API = "https://learnwebcode.github.io/json-example/animals-";
let animalGroupNum = 1;

function handleButtonClick(button) {
    request.open("GET", API + animalGroupNum + ".json");

    request.onload = () => {
        if (request.status >= 200 && request.status < 400) {
            const animals = JSON.parse(request.responseText);
            for (const animal of animals) {
                addNewAnimal(animal);
            }

            animalGroupNum++;

            if (animalGroupNum === 4) {
                button.classList.add("hidden");
            }
        }
    };

    request.onerror = (err) => {
        alert(err);
    };

    request.send();
}

const handleButtonClickV2 = (button) => {
    fetch(API + animalGroupNum + ".json")
        .then(res => res.json())
        .then(animals => {
            for (const animal of animals) {
                addNewAnimal(animal);
            }

            animalGroupNum++;

            if (animalGroupNum === 4) {
                $('#btn').hide();
            }
        }).catch(err => {
        const reason = err.json;
        alert(reason);
    });
};

const addNewAnimal = (animal) => {
    let result = "<p>" + animal.name + "</p>";

    $('#animals').append(result);
};

document.addEventListener("DOMContentLoaded", function () {
    let button = document.getElementById("btn");

    button.addEventListener("click", () => handleButtonClickV2(button));
});
