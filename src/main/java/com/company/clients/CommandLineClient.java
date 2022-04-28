package com.company.clients;

import com.company.core.CoreCronParser;
import com.company.core.ModelConvertor;
import com.company.core.OutPutHandler;
import com.company.model.CronExpressionInput;
import com.company.model.CronExpressionOutput;
import com.company.output.IOutPutWriter;
import com.company.output.OutputWriterFactory;

import java.io.ByteArrayOutputStream;

public class CommandLineClient {

    private ModelConvertor modelConvertor;
    private CoreCronParser coreCronParser;
    private OutputWriterFactory outputWriterFactory;

    private static CommandLineClient commandLineClient = new CommandLineClient();


    //Default constructor
    public CommandLineClient() {
        this.modelConvertor =  new ModelConvertor();
        this.coreCronParser  = new CoreCronParser();
        this.outputWriterFactory = new OutputWriterFactory();
    }

    public CommandLineClient(ModelConvertor modelConvertor, CoreCronParser coreCronParser,OutputWriterFactory outputWriterFactory) {
        this.modelConvertor = modelConvertor;
        this.coreCronParser = coreCronParser;
        this.outputWriterFactory = outputWriterFactory;
    }

    public static CommandLineClient commandLineClientWithOutputWriterFactory(OutputWriterFactory outputWriterFactory) {
        CommandLineClient commandLineClient = new CommandLineClient();
        commandLineClient.outputWriterFactory = outputWriterFactory;
        return commandLineClient;
    }

    public static void main(String[] args) {
        commandLineClient.parse(args);
    }

    public void parse(String[] args){
        // Convert the provided args/commands to typed input model
        CronExpressionInput cronExpressionInput = this.modelConvertor.convertToInputModel(args);

        //Provide the input to CoreParser to parse and handle/process the output
        CronExpressionOutput cronExpressionOutput =  this.coreCronParser.parse(cronExpressionInput);

        // Handle output, Currently only supporting one output/writer type, not diff for multiple commands
        IOutPutWriter outputWriter = this.outputWriterFactory.createOutputWriter(cronExpressionInput.getOutputType());
        outputWriter.write(cronExpressionOutput);
    }
}
