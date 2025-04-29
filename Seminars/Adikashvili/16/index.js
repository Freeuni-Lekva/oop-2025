
function addStudent() {
    const firstName = document.getElementById('first-name').value;
    const lastName = document.getElementById('last-name').value;

    if (firstName === '' || lastName === '') {
        alert("empty fields");
        return;
    }

    const table = document.getElementById('students-table');

    const newStudent = table.insertRow();
    const firstNameRow = newStudent.insertCell(0);
    const lastNameRow = newStudent.insertCell(1);

    firstNameRow.innerHTML = firstName;
    lastNameRow.innerHTML = lastName;
}