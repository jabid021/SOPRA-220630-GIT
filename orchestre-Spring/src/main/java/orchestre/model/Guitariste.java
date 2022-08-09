package orchestre.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Guitariste implements IMusicien{
	
	@Autowired
	@Qualifier("piano")
	private IInstrument instrument;
	
	public Guitariste() {
		//System.out.println("Le guitariste equipe sa "+instrument.getClass().getSimpleName());
	}
	
	public IInstrument getInstrument() {
		return instrument;
	}



	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}



	@Override
	public void jouer() {
		System.out.println("Le guitariste joue ! "+instrument.son());
		
	}

}
