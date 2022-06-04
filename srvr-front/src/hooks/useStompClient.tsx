/* eslint-disable react-hooks/exhaustive-deps */
import { useEffect, useRef, useState } from "react";
import * as StompJs from "@stomp/stompjs"
import StompClient from "@/services/websocket";

interface Subscription {
    destination: string;
    callback: StompJs.messageCallbackType;
    headers?: StompJs.StompHeaders;
    active: boolean;
}

interface SendMessage {
    destination: string;
    headers?: { [key: string]: any },
    body?: string;
}

export default function useStompClient() {
    const webStompClient = useRef<StompJs.CompatClient>(StompClient);
    const [subscriptions, setSubscriptions] = useState<Map<string, Subscription>>(new Map());
    const [sendMessage, setSendMessage] = useState<SendMessage>();

    webStompClient.current.onConnect = () => {
        subscriptions.forEach(subscription => {
            subscription.active = false;
        })
        setSubscriptions((prev) => new Map(prev))
    }

    useEffect(()=> {
        if(webStompClient.current.connected) {
            subscriptions.forEach(subscription => {
                if(!subscription.active){
                    subscription.active = true;
                    const { destination, callback, headers } = subscription;
                    webStompClient.current.subscribe(destination, callback, headers);
                }
            });
        }
    }, [subscriptions])

    useEffect(() => {
        if (webStompClient.current.connected && sendMessage) {
            const { destination, headers, body } = sendMessage;
            webStompClient.current.send(destination, headers, body);
            setSendMessage(undefined);
        }
    }, [sendMessage])

    function send(destination: string, headers?: { [key: string]: any }, body?: string) {
        setSendMessage({ destination, headers, body })
    }

    function subscribe(destination: string, callback: StompJs.messageCallbackType, headers?: StompJs.StompHeaders) {
        setSubscriptions((prev) => new Map(prev).set(destination, { destination, callback, headers, active: false }));
    }

    function unsubscribe(destination: string) {
        setSubscriptions((prev) => {
            const newMap = new Map(prev);
            webStompClient.current.unsubscribe(destination);
            newMap.delete(destination);
            return newMap;
        });
    }

    return {send, subscribe, unsubscribe};
}