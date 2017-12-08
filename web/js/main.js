const burgerFunction = () => {
    const x = document.getElementById("Topnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
};
document.querySelector('#burger').addEventListener('click', (burgerFunction));