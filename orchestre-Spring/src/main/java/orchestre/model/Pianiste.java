package orchestre.model;

public class Pianiste implements IMusicien{
	
	private Piano instrument;
	
	public Pianiste() {
		//System.out.println("Le pianiste equipe son "+instrument.getClass().getSimpleName());
	}
	
	public Piano getInstrument() {
		return instrument;
	}



	public void setInstrument(Piano instrument) {
		this.instrument = instrument;
	}



	@Override
	public void jouer() {
		System.out.println("Le pianiste joue ! "+instrument.son());
		
	}

}
