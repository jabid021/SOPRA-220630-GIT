package orchestre.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitariste implements IMusicien{
	
	@Autowired
	@Qualifier("guitare")
	private IInstrument instrument;
	
	/*public Guitariste(Guitare instrument) {
		System.out.println("Le guitariste equipe sa "+instrument.getClass().getSimpleName());
	}*/
	
	
	public Guitariste() {
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
