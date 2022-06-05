import * as StompJs from '@stomp/stompjs';
import SockJS from "sockjs-client";

const url = "http://localhost:8080/websocket/main";
const client = StompJs.Stomp.over(() => new SockJS(url));

client.reconnect_delay = 2000;

client.onConnect = function (frame) {
    console.info('connecting');
};

client.onStompError = function (frame) {
    console.info('Broker reported error: ' + frame.headers['message']);
    console.info('Additional details: ' + frame.body);
};

client.onDisconnect= function (frame) {
    console.log('disconnect');
}

client.activate();

export default client;