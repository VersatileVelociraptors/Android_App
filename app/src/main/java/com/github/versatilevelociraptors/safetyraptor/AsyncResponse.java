package com.github.versatilevelociraptors.safetyraptor;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Harvey on 10/30/2016.
 */

public interface AsyncResponse {
    void print(String output);
    void setPrintWriter(PrintWriter writ);
    void setSocket(Socket socket);
}
