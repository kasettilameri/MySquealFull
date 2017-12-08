"use strict";
const myForm = document.querySelector('form');
const fData = new FormData(myForm);
const settings = {
    method: 'post',
    data: fData
};
fetch('JsonResponseServlet', settings)
    .then((response) => {
        return response.json();
    })
    .then((result) => {
        console.log(result);
});
