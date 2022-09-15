for(let li of document.querySelectorAll('.instru-a-valider')){    
    li.addEventListener('click',()=>{
        document.querySelectorAll('.ok-nok.open').forEach(btn => btn.classList.remove('open'));
        li.querySelectorAll('.ok-nok').forEach(btn => btn.classList.add('open'));        
    })
}

document
    .querySelector('#voir-instru-a-valider')
    .addEventListener('click',()=>{
        document.querySelectorAll('.test.open').forEach(btn => btn.classList.remove('open'));
        document.querySelector('#instruments-a-valider').classList.add('open');
        
    })

    document
    .querySelector('#voir-stats-instru')
    .addEventListener('click',()=>{
        document.querySelectorAll('.test.open').forEach(btn => btn.classList.remove('open'));
        document.querySelector('#stats-instruments').classList.add('open');
        
    })
    