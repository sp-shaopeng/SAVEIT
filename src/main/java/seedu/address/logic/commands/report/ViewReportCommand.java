package seedu.address.logic.commands.report;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class ViewReportCommand extends Command {

    public static final String COMMAND_WORD = "view" ;


    public ViewReportCommand(){

    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return null;
    }
}
