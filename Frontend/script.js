
  
function showUsers(){
    //alert("You doing good");

    fetch("http://localhost:8080/users")// api end point
    .then((response)=>response.json())
    .then((users) =>{
        const tableData=document.getElementById("userTableBody");
        users.forEach( user=> {
            var row =`<tr>
            <td>${user.sno}</td>
            <td>${user.fName}</td>
            <td>${user.lName}</td>
            <td>${user.emailId}</td>
            <td>${user.phoneNo}</td>
            <td>  <button onclick="updateUserPage(${user.sno})">Update</button>
                 <button style="background-color: green;" onclick="deleteUser(${user.sno})">Delete</button>
                 <button onclick="viewUser(${user.sno})">View</button>
            </td>
            </tr>`
            tableData.innerHTML+=row;
        });
    });
}

function updateUserPage(sno) {
    window.location.href = `update.html?sno=${sno}`;
  }
function deleteUser(sno) {
    fetch(`http://localhost:8080/users/${sno}`, {
        method: 'DELETE',
    })
    .then(response => {
        if (response.ok) {
            alert("User deleted successfully!");
            location.reload(); // Refresh the page
        } else {
            alert("Failed to delete user.");
        }
    });
}
function viewUser(sno) {
    fetch(`http://localhost:8080/users/${sno}`)
    .then(response => response.json())
    .then(user => {
        alert(
            `Name: ${user.fName} ${user.lName}\nEmail: ${user.emailId}\nPhone: ${user.phoneNo}`
        );
    });
}




