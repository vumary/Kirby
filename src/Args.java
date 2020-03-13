
public class Args {
	
	private boolean stack = false;			//use the stack-based approach
	private boolean queue = false;			//use the queue-based approach
	private boolean opt = false; 			//find the shortest path
	private boolean time = false; 			//print runtime
	private boolean inCoordinate = false;	//if true, input is coord; if false, input is grid
	private boolean outCoordinate = false;	//if true, output is coord; if false, output is grid
	private boolean help = false; 			//brief, informative message about program and the switches

	public Args() {}
	
	public void transverse(String[] args) {
		
		for(int i=0; i<args.length; i++) {
			if(args[i].equals("--Stack")&&stack) {
				System.out.println("Error: Legal command line inputs must include exactly one of --Stack, --Queue, or --Opt.");
				System.exit(-1);
			}
			else if(args[i].equals("--Queue")&&queue) {
				System.out.println("Error: Legal command line inputs must include exactly one of --Stack, --Queue, or --Opt.");
				System.exit(-1);
			}
			else if(args[i].equals("--Opt")&&opt) {
				System.out.println("Error: Legal command line inputs must include exactly one of --Stack, --Queue, or --Opt.");
				System.exit(-1);
			}
			else if(args[i].equals("--Stack")&&!stack) {
				stack = true;
			}
			else if(args[i].equals("--Queue")) {
				queue = true;
			}
			else if(args[i].equals("--Opt")) {
				opt = true;
			}
			else if(args[i].equals("--Time")) {
				time = true;
			}
			else if(args[i].equals("--Incoordinate")) {
				inCoordinate = true;
			}
			else if(args[i].equals("--Outcoordinate")) {
				outCoordinate = true;
			}
			else if(args[i].equals("--Help")) {
				help = true;
			}
		}
		
	}
	
	public boolean getStack() {
		return stack;
	}

	public void setStack(boolean stack) {
		this.stack = stack;
	}

	public boolean getQueue() {
		return queue;
	}

	public void setQueue(boolean queue) {
		this.queue = queue;
	}

	public boolean getOpt() {
		return opt;
	}

	public void setOpt(boolean opt) {
		this.opt = opt;
	}

	public boolean getTime() {
		return time;
	}

	public void setTime(boolean time) {
		this.time = time;
	}

	public boolean getInCoordinate() {
		return inCoordinate;
	}

	public void setInCoordinate(boolean inCoordinate) {
		this.inCoordinate = inCoordinate;
	}

	public boolean getOutCoordinate() {
		return outCoordinate;
	}

	public void setOutCoordinate(boolean outCoordinate) {
		this.outCoordinate = outCoordinate;
	}

	public boolean isHelp() {
		return help;
	}

	public void setHelp(boolean help) {
		this.help = help;
	}
	
}
