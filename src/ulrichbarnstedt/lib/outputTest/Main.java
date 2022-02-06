package ulrichbarnstedt.lib.outputTest;

import ulrichbarnstedt.lib.output.color.AsciiList;
import ulrichbarnstedt.lib.output.color.TextFormatting;
import ulrichbarnstedt.lib.output.color.TrueColor;
import ulrichbarnstedt.lib.output.render.elments.*;
import ulrichbarnstedt.lib.output.render.style.BoxStyle;
import ulrichbarnstedt.lib.output.render.style.PaddingStyle;
import ulrichbarnstedt.lib.output.terminal.Cursor;

public class Main {
    public static void main (String[] args) {

        Container cont1 = new Container(true, true)
            .setPadding(new PaddingStyle(2, 3))
            .setColor(new TrueColor(0, 255, 255, true).toString())
            .addElement(
                new Text("Welcome to the demo")
                    .setColor(AsciiList.FG_GREEN.toString())
            )
            .addElement(
                new Spacer(0, 1)
            )
            .addElement(
                new MultilineText(
                    "This is the main text of the demo",
                    "In a convenient multi-",
                    "line-",
                    "box."
                )
            )
            .addElement(
                new Spacer(1)
            )
            .addElement(
                new Container(true, true)
                    .addElement(
                        new Text("Even with nested boxes!")
                    )
            )
            .addElement(
                new Spacer(1)
            )
            .addElement(
                new Container(false, true)
                    .addElement(
                        new Container(true, true)
                            .addElement(new Text("Side-"))
                            .setPadding(new PaddingStyle(1, 1))
                    )
                    .addElement(
                        new Container(true, true)
                            .addElement(new Text("ways!"))
                            .setPadding(new PaddingStyle(1, 1))
                    )
                    .addElement(
                        new Container(true, true)
                            .addElement(new Text("(And separate padding!)"))
                            .setPadding(new PaddingStyle(1, 4, 4, 1))
                    )
            )
            .addElement(
                new Spacer(1)
            )
            .addElement(
                new Container(true, true)
                    .addElement(
                        new Text("Titles? Yep.")
                    )
                    .setTitle("Fancy")
                    .setPadding(new PaddingStyle(2 ,1))
            )
            .addElement(
                new Spacer(1)
            )
            .addElement(
                new MultilineText(
                    "Or some fancy sideways design?",
                    "Containers do all the work!"
                )
            )
            .addElement(
                new Spacer(1)
            )
            .addElement(
                new Container(false, false)
                    .addElement(
                        new Container(true, true)
                            .setPadding(new PaddingStyle(3, 1))
                            .addElement(
                                new Text("Works like normal")
                                    .setColor(AsciiList.BG_RED + "" + TextFormatting.SET_UNDERLINE)
                            )
                    )
                    .addElement(
                        new Container(true, true)
                            .setPadding(new PaddingStyle(3, 1))
                            .addElement(
                                new Text("With custom borders!")
                            )
                            .setBoxDrawingCharacters(
                                BoxStyle.defaultStyle()
                                    .setVERTICAL("|")
                                    .setHORIZONTAL("-")
                                    .setLT("+")
                                    .setLB("+")
                                    .setRT("+")
                                    .setRB("+")
                            )
                    )
            );

        Container cont2 = new Container(true, true)
            .setPadding(new PaddingStyle(2, 3))
            .setColor(AsciiList.FG_RED)
            .addElement(
                new Text("Quite the framework, eh?")
                    .setColor(AsciiList.FG_GREEN + "" + TextFormatting.SET_ITALIC)
            )
            .addElement(
                new Spacer(2)
            )
            .addElement(
                new Text("Oh and btw, mutiple screen support! (With auto-switching!)")
            )
            .addElement(
                new Spacer(2)
            )
            .addElement(
                new Text("And since 2.0:")
                    .setColor(TextFormatting.SET_ITALIC)
            )
            .addElement(
                new Text("Table support!")
                    .setColor(AsciiList.BG_GREEN)
            )
            .addElement(
                new SubdividedTable(true)
                    .setPadding(new PaddingStyle(1, 1))
                    .addElement(0, new Text("With text inside").setColor(TextFormatting.SET_BOLD + "" + TextFormatting.SET_UNDERLINE))
                    .addElement(0, new MultilineText("Or", "multi", "line"))
                    .addElement(1, new Container(true, true)
                        .addElement(new Text("And containers"))
                        .setColor(AsciiList.FG_MAGENTA)
                    )
                    .addElement(2, new Empty())
                    .addElement(3, new Empty())
                    .addElement(3, new Text("<-- And empty columns"))
            )
            .setTitle("Box no.2");

        Screen test1 = new Screen(
            new Container(false, false)
                .addElement(cont1)
                .addElement(cont2)
        );

        ScreenManager scrmg = new ScreenManager()
            .addScreen("test1", test1)
            .open("test1");

        test1.cursorToEnd().p();
    }
}
