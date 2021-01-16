package creature;

import com.zpy.yearn.common.YearnException;
import com.zpy.yearn.dict.relation.entity.State;

public abstract class Desire implements State {

	DesireStatus status;

	// actualOccurence;
	public abstract void run();

	public void satisfy() throws YearnException {
		if( this.status == DesireStatus.Unsatisfied ){
			this.status = DesireStatus.Satisfied;
		}else{
			throw new YearnException("trying to satisfy a satisfied desire!");
		}
	}

	public void changeState() throws YearnException {
		satisfy();
	}
}

enum DesireStatus {
		Unsatisfied
		,Satisfied
		}
