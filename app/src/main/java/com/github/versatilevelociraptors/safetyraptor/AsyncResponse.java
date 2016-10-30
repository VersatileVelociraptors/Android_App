package com.github.versatilevelociraptors.safetyraptor;

import java.io.PrintWriter;

/**
 * Created by Harvey on 10/30/2016.
 */

public interface AsyncResponse {
    void print(String output);
    void setPrintWriter(PrintWriter writ);
}
