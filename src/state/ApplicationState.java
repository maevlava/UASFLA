package state;

import model.Pelanggan;

public interface ApplicationState {
    void runSubProgram(Pelanggan pelanggan);
    void exit();
}
