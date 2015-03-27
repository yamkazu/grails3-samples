package commands

import org.crsh.cli.Command
import org.crsh.cli.Usage

class hello {

    @Usage('Say Hello')
    @Command
    def main(InvocationContext context) {
        'Hello'
    }
}
