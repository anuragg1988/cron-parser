package com.company.output;

import com.company.clients.CommandLineClient;
import com.company.exception.InvalidOutPutHandlerException;
import com.company.model.OutPutTypeStrInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class OutputWriterFactory {

    // TODO Migrate to do lazy initialisation
    private IOutPutWriter consoleOutPutWriter;
    private IOutPutWriter fileOutPutWriter;

    public OutputWriterFactory(IOutPutWriter consoleOutPutWriter, IOutPutWriter fileOutPutWriter) {
        this.consoleOutPutWriter = consoleOutPutWriter;
        this.fileOutPutWriter = fileOutPutWriter;
    }

    public OutputWriterFactory() {
        this.consoleOutPutWriter = new ConsoleOutPutWriter();
        this.fileOutPutWriter = new FileOutPutWriter();
    }

    public static OutputWriterFactory withCustomOutputWriter(IOutPutWriter consoleOutPutWriter) {
        OutputWriterFactory outputWriterFactory = new OutputWriterFactory();
        outputWriterFactory.consoleOutPutWriter = consoleOutPutWriter;
        return outputWriterFactory;
    }

    public IOutPutWriter createOutputWriter(OutPutTypeStrInput type){
        OutputType outputType = getOutPutType(type);
        IOutPutWriter outPutWriter;
        switch (outputType){
            case FILE: {
                outPutWriter = this.fileOutPutWriter;
                break;
            }
            default: {
                outPutWriter = this.consoleOutPutWriter;// Default to console type
                break;
            }
        }
        return outPutWriter;
    }

    private OutputType getOutPutType(OutPutTypeStrInput outPutTypeStrInput) {
        // Default to console type
        OutputType outputType = OutputType.CONSOLE;
        if(outPutTypeStrInput != null){
            String type = outPutTypeStrInput.getOutputType();
            if(type != null && type.isEmpty()){
                try{
                    outputType = OutputType.valueOf(type);
                }
                catch (IllegalArgumentException ex){
                    throw new InvalidOutPutHandlerException("Invalid output write handler parameter provided: "+type+" , valid values are: "+ Arrays.toString(OutputType.values()), ex);
                }
            }
        }
        return outputType;
    }
}
