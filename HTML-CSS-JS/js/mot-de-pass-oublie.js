// Ouverture de la popup
document
.querySelector('button.open-popup')
.addEventListener('click', () => {
    document
    .querySelector('.popup-overlay')
    // .style.display = 'block';
    .classList.add('open');

    document
    .querySelector('.popup-container')
    .classList.add('open');
});


// Fermeture de la popup
document
.querySelector('button.close-popup')
.addEventListener('click', () => {
    document
    .querySelector('.popup-overlay')
    // .style.display = 'none';
    .classList.remove('open');

    document
    .querySelector('.popup-container')
    .classList.remove('open');
});