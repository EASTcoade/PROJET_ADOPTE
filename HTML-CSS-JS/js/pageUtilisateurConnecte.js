
const send = () => {
    const message = document.querySelector("input[name='text']").value;
    const divMessage = document.createElement('div');

    divMessage.innerText = message;
    document.querySelector(".messages > div").append(divMessage);

    document.querySelector("input[name='text']").value="";
    document.querySelector(".messages > div").scrollTop = document.querySelector(".messages > div").scrollHeight;

    // TODO : Envoyer le message à JAVA
};


document.querySelector(".envoyer").addEventListener("click", send);

document.querySelector("input[name='text']").addEventListener("keydown", (event) => {
    // Touche entrée
    if (event.keyCode == 13) {
        send();
    }
});

