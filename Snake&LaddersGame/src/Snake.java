
public class Snake extends Move{

	public Snake(Integer startno, Integer endno) {
		super();
		if(startno < endno) {
			System.out.println("Wrong Parameters");
		}
		else {
		this.startno = startno;
		this.endno = endno;
		
		}
	}
}
