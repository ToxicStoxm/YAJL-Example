package com.toxicstoxm.Application;

import com.toxicstoxm.Main;
import com.toxicstoxm.YAJL.YAJLLogger;
import com.toxicstoxm.logger.YAJLExampleLogAreas;

public class ExampleApp implements Runnable {
    // main logger instance
    public static YAJLLogger logger;

    public ExampleApp() {

        // initializing logger
        logger = YAJLLogger.withArea(
                Main.projectDir, // project Directory (the logger uses this to store its yajl-config.yaml file)
                System.out, // the output stream the logger should use to write the log messages to
                new YAJLExampleLogAreas.UNDEFINED(), // the default log area to use if non was specified
                new YAJLExampleLogAreas(), // the log area bundle to use (this must include the above-specified default log area)
                true // if the logger should enable the area wildcard option for its config file ('ALL' to enable all log areas)
        );

    }

    public void run() {

        // Simple hello World test with no log areas (Equal to System.out.println())
        logger.log("Hello World!");

        // Log level usage examples
        logger.fatal("A fatal error occurred! Restart required!"); // Fatal log message with no log area specified (fatal errors, crash, unable to continue execution without a restart)
        logger.error("An unexpected error occurred while trying to load X!"); // Error log message with no log area specified (errors, recoverable, not fatal)
        logger.warn("X was not specified in the config file"); // Warning log message with no log area specified (warnings, recoverable, less important things that have gone wrong, or unexpected results etc.)
        logger.info("X was successfully started! (took Xms)"); // Info log message with no log area specified (printing normal information messages to the console)
        logger.debug("X is missing. Creating new X to fulfill X!"); // Debug log message with no log area specified (debugging your application)
        logger.verbose("X: Initializing X: Creating X: Loading X ... Complete"); // Verbose log message with no log area specified (indepth logging of your application, Debug+)
        logger.stacktrace("at X ... X ... X:Line:X ..."); // Stacktrace log message with no log area specified (actual stack-traces or detailed error messages)

        // Spacer
        logger.log("-----------------------------------------------------------------------------------");

        // Log level + Area usage examples
        logger.fatal("The network connection was unexpectedly closed by remote! Can't continue execution!", new YAJLExampleLogAreas.NETWORK());
        logger.error("An error occurred while trying to set the default size for the main window!", new YAJLExampleLogAreas.WINDOW());
        logger.warn("Vale for X has an invalid format in X config. Using default value!", new YAJLExampleLogAreas.CONFIG());
        logger.info("Starting application...", new YAJLExampleLogAreas.GENERAL());
        logger.debug("WindowCallbackHandler returned false, expected true", new YAJLExampleLogAreas.UI());
        logger.verbose("UI: Window: Loading Network interconnect: remote -> 200 OK", new YAJLExampleLogAreas.UI_NETWORK_BRIDGE());
        logger.stacktrace("Received unexpected response from remote at someClass.SomeSubClassSomeLineNumber: X, using fallback connection stored in X!", new YAJLExampleLogAreas.NETWORK());

    }
}
