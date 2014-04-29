package Control;

import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class MyPrintStream extends PrintStream {
 
     private Text text;
    
    public MyPrintStream(OutputStream out, Text text) {
        super(out);
        this.text = text;
    }

    /**
     * �������ؽ�,���еĴ�ӡ������Ҫ���õķ���
     */
    public void write(byte[] buf, int off, int len) {
        final String message = new String(buf, off, len);
        
        /* SWT�ǽ����̷߳�������ķ�ʽ */
        Display.getDefault().syncExec(new Thread(){
            public void run(){
                /* ���������Ϣ��ӵ������ */
                text.append(message +"\n");
            }
        });
    }
    
}