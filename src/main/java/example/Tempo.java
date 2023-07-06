package example;

public class Tempo {
	private int bpm;
	
	public Tempo(int bpm) {
        this.bpm = bpm;
    }
	
	public double getHz() {
		return bpm / 60.0;
	}
	
	@Override
	public String toString() {
        return "Tempo [bpm=" + bpm + "]";
    }
}