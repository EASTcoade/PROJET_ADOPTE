const express = require('express');
const app = express();
const http = require('http');
const { disconnect } = require('process');
const server = http.createServer(app);
const {Server} = require("socket.io");


const io = new Server(server, {
  cors: {
    origin: "*",
    methods: ["GET", "POST"]
  }
});


app.get('/', (req, res) => {
  console.log("hello world")  
  res.send("hello world")
  });


io.on('connection', (socket)=>{
    console.log('a user connected');
    socket.on('message',(msg)=>{
        console.log('message : ' + msg);
        io.emit('message', msg);
    })

    
    socket.on('disconnect',()=>{
    console.log('user disconnected')
    })
})

server.listen(3000, () => {
  console.log('listening on *:3000');
});