const overlay=document.querySelector('.popup-overlay');
const container=document.querySelector('.popup-container');
const imgTriangle=document.querySelector('#imgTriangle')

document.querySelector('button.afficher')
    .addEventListener("click",()=>{
        overlay.classList.add('open');
        container.classList.add('open');

        document.getElementById("myaudio").play();        
});


document.querySelector('#fermer')
    .addEventListener("click",()=>{
        overlay.classList.remove('open');
        container.classList.remove('open');
});



