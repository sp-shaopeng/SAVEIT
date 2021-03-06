package seedu.saveit.logic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.saveit.commons.core.GuiSettings;
import seedu.saveit.commons.core.LogsCenter;
import seedu.saveit.logic.commands.Command;
import seedu.saveit.logic.commands.CommandResult;
import seedu.saveit.logic.commands.ReportCommand;
import seedu.saveit.logic.commands.ReportCommandResult;
import seedu.saveit.logic.commands.exceptions.CommandException;
import seedu.saveit.logic.parser.TopLevelParser;
import seedu.saveit.logic.parser.exceptions.ParseException;
import seedu.saveit.logic.parser.report.ReportWindowParser;
import seedu.saveit.model.Model;
import seedu.saveit.model.ReadOnlyAccountList;
import seedu.saveit.model.expenditure.BaseExp;
import seedu.saveit.model.expenditure.Expenditure;
import seedu.saveit.model.expenditure.Repeat;
import seedu.saveit.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final TopLevelParser topLevelParser;
    private final ReportWindowParser reportWindowParser;

    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        topLevelParser = new TopLevelParser();
        reportWindowParser = new ReportWindowParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = topLevelParser.parseCommand(commandText);
        commandResult = command.execute(model);

        try {
            storage.saveSaveIt(model.getAccountList());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    @Override
    public ReportCommandResult executeReportWindowCommand(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");
        ReportCommandResult commandResult;
        ReportCommand command = reportWindowParser.parse(commandText);
        commandResult = command.execute(model);
        return commandResult;
    }

    @Override
    public ReadOnlyAccountList getAddressBook() {
        return model.getAccountList();
    }

    @Override
    public ObservableList<Expenditure> getFilteredExpenditureList() {
        return model.getFilteredExpenditureList();
    }

    @Override
    public ObservableList<Repeat> getFilteredRepeatList() {
        return model.getFilteredRepeatList();
    }

    @Override
    public ObservableList<BaseExp> getFilteredBaseExpList() {
        return model.getFilteredBaseExpList();
    }

    @Override
    public Path getAddressBookFilePath() {
        return model.getAddressBookFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }
}
