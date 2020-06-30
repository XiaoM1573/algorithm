class CQueue {

	LinkedList<Integer> A;// 用于入栈
	LinkedList<Integer> B;// 用于出栈

	public CQueue() {
		A = new LinkedList<>();
		B = new LinkedList<>();
	}

	public void appendTail(int value) {
		A.addLast(value);
//		这里不需要再次把栈B的内容逆序导入栈A中，仔细想想，应该明白
//		if (!A.isEmpty()) {
//			A.addLast(value);
//		} else {
//			while (!B.isEmpty()) {
//				A.addLast(B.removeLast());
//			}
//			A.addLast(value);
//		}
	}

	public int deleteHead() {
    	if(!B.isEmpty()) {
    		return B.removeLast();
    	}else {
    		if(A.isEmpty()) return -1;
    		while(!A.isEmpty()) {
    			B.addLast(A.removeLast());
    		}
    		return B.removeLast();
    	}
    }
}
