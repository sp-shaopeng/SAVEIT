package seedu.address.logic.commands.general;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": saves data and closes the application";
    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting $AVE IT as requested ...";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, true, false, false,
                false, false, false, false);
    }

}
