package me.hfox.idea.streamdeck.wss;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class DeckWss extends WebSocketServer {

    public DeckWss(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        //
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        //
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        //
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        //
    }

    @Override
    public void onStart() {
        //
    }

}
