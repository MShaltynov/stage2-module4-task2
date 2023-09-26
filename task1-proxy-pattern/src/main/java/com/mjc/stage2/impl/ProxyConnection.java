package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private final RealConnection realConnection;
    private boolean isClosed;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        // Write your code here!
        if (!isClosed && realConnection != null && !realConnection.isClosed()   ) {
            realConnection.close();
            isClosed = true;
        }
    }

    @Override
    public void close() {
        isClosed = false;
    }

    @Override
    public boolean isClosed() {
        return isClosed || (realConnection != null && realConnection.isClosed());
    }
    // Implement methods here!
}
