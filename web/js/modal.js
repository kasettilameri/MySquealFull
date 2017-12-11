'use strict';

/*=== maybe later button ===*/
const maybeLtrButton = document.querySelector('#maybeLtr');

/*=== signUp modal ===*/
const formModal = document.querySelector('.modal');


/*=== closes modal if user clicks maybe later button ===*/
maybeLtrButton.addEventListener('click', (closeModal) => {
    formModal.style.display = "none";
});
