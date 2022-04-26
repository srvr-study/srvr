import * as StompJs from '@stomp/stompjs';
import SockJS from "sockjs-client";

const sockJs = new SockJS("http://localhost:8080/main");
const client = StompJs.Stomp.over(sockJs)

client.onConnect = function (frame) {
    console.log('connecting');
};

client.onStompError = function (frame) {
    console.log('Broker reported error: ' + frame.headers['message']);
    console.log('Additional details: ' + frame.body);
};

client.activate();

export default client;