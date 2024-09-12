package gitlet;

import java.io.File;

import static gitlet.Utils.*;

// TODO: any imports you need here

/**
 * Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 * @author RobinYe
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /**
     * The current working directory.
     */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /**
     * The .gitlet directory.
     */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /* TODO: fill in the rest of this class. */
    public static void init() {
        if (GITLET_DIR.exists()) {
            GITLET_DIR.mkdir();
        } else {
            System.err.println("A Gitlet version-control system already exists in the current directory.");
        }
        // TODO
    }

    public static void add(String file) {

    }

    public static void commit(String message) {
        // TODO
        // Invoke Commit class
    }

    public static void rm(String file) {
        // TODO
        System.err.println("No reason to remove the file.");
    }

    public static void log() {
        // TODO
    }

    public static void global-

    log() {
        // TODO
        // A useful method in Utils.
    }

    public static void find() {
        // TODO
    }

    public static void status() {
        // TODO
    }

    public static void checkout() {
        // TODO
    }


    public static void branch(String branch) {
        // TODO
    }

    public static void rm-branch(String branch) {
        // TODO
    }

    public static void reset(String commitID) {
        // TODO
    }

    public static void merge(String branch) {
        // TODO
    }
}