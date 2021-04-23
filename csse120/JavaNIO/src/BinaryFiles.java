import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.*;

public class BinaryFiles {
	public static void main(String[] args) {
		
		try {
			Pipe pipe=Pipe.open();
			Runnable writer=new Runnable() {
				@Override
				public void run() {
					try {
						Pipe.SinkChannel sinkChannel=pipe.sink();
						ByteBuffer buffer=ByteBuffer.allocate(56);
						
						for(int i=0;i<10;i++) {
							String currentTime="the time is: "+System.currentTimeMillis();
							buffer.put(currentTime.getBytes());
							buffer.flip();
							while(buffer.hasRemaining()) {
								sinkChannel.write(buffer);
							}
							buffer.flip();
							Thread.sleep(100);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			};
			
			Runnable reader=new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Pipe.SourceChannel sourceChannel=pipe.source();
						ByteBuffer buffer=ByteBuffer.allocate(56);
						
						for(int i=0;i<10;i++) {
							int bytesread=sourceChannel.read(buffer);
							byte[] timestring=new byte[bytesread];
							buffer.flip();
							buffer.get(timestring);
							System.out.println("Reader Thread: "+new String(timestring));
							buffer.flip();
							Thread.sleep(100);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			};
			
			new Thread(writer).start();
			new Thread(reader).start();
			
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
//		try(FileOutputStream binFile=new FileOutputStream("data.dat");
//				FileChannel binChannel=binFile.getChannel()) {
//			ByteBuffer buffer=ByteBuffer.allocate(100);
//			/*byte[] output="Hello World!".getBytes();
//			byte[] output2="nice to meet you".getBytes();
//			buffer.put(output).putInt(245).putInt(-98765).put(output2).putInt(1000);
//			buffer.flip();
//			binChannel.write(buffer);
//			*/
//			//another way of writing above code
//			byte[] output="Hello World!".getBytes();
//			buffer.put(output);
//			long int1pos=output.length;
//			buffer.putInt(245);
//			long int2pos=int1pos+Integer.BYTES;
//			buffer.putInt(-98765);
//			byte[] output2="nice to meet you".getBytes();
//			buffer.put(output2);
//			long int3pos=int2pos+output2.length+Integer.BYTES;
//			buffer.putInt(1000);
//			buffer.flip();
//			binChannel.write(buffer);
//			
//			
//		
//			RandomAccessFile ra=new RandomAccessFile("data.dat", "rwd");
//			FileChannel channel=ra.getChannel();
//			ByteBuffer readBuffer=ByteBuffer.allocate(Integer.BYTES);
//			channel.position(int3pos);
//			channel.read(readBuffer);
//			readBuffer.flip();
//			System.out.println("int3 = "+readBuffer.getInt());
//			
//			readBuffer.flip();
//			channel.position(int2pos);
//			channel.read(readBuffer);
//			readBuffer.flip();
//			System.out.println("int2 = "+readBuffer.getInt());
//		
//			readBuffer.flip();
//			channel.position(int1pos);
//			channel.read(readBuffer);
//			readBuffer.flip();
//			System.out.println("int1 = "+readBuffer.getInt());
//			
//			RandomAccessFile copyFile=new RandomAccessFile("copydata.dat", "rw");
//			FileChannel copyChannel=copyFile.getChannel();
//			channel.position(0);
//			//long numtransferred=copyChannel.transferFrom(channel,0,channel.size());
//			long numtransferred=channel.transferTo(0,channel.size(), copyChannel);
//			System.out.println("Num transferred = "+numtransferred);
//			
//			channel.close();
//			ra.close();
//			copyChannel.close();
//			
//			byte[] outputstring="hello, world!".getBytes();
//			long str1pos=0;
//			long newint1pos=outputstring.length;
//			long newint2pos=newint1pos+Integer.BYTES;
//			byte[] outputstring2="nice to meet you".getBytes();
//			long str2pos= newint2pos+Integer.BYTES;
//			long newint3pos=str2pos+outputstring2.length;
//			
//			ByteBuffer intBuffer=ByteBuffer.allocate(Integer.BYTES);
//			intBuffer.putInt(245);
//			intBuffer.flip();
//			binChannel.position(newint1pos);
//			binChannel.write(intBuffer);
//			
//			intBuffer.flip();
//			intBuffer.putInt(-98765);
//			intBuffer.flip();
//			binChannel.position(newint2pos);
//			binChannel.write(intBuffer);
//			
//			intBuffer.flip();
//			intBuffer.putInt(1000);
//			intBuffer.flip();
//			binChannel.position(newint3pos);
//			binChannel.write(intBuffer);
//			
//			binChannel.position(str1pos);
//			binChannel.write(ByteBuffer.wrap(outputstring));
//			binChannel.position(str2pos);
//			binChannel.write(ByteBuffer.wrap(outputstring2));
//			
//			
//			
//			/*ByteBuffer readBuffer=ByteBuffer.allocate(100);
//			channel.read(readBuffer);
//			readBuffer.flip();
//			byte[] inputstring=new byte[output.length];
//			readBuffer.get(inputstring);
//			System.out.println("input string 1 = "+new String(inputstring));
//			System.out.println("int1 = "+readBuffer.getInt());
//			System.out.println("int2 = "+readBuffer.getInt());
//			byte[] inputstring2=new byte[output2.length];
//			readBuffer.get(inputstring2);
//			System.out.println("input string 2 = " + new String(inputstring2) );
//			System.out.println("int3 = "+readBuffer.getInt());
//			*/
//			
//			
//			//ByteBuffer buffer=ByteBuffer.wrap(output);
//	/*		ByteBuffer buffer=ByteBuffer.allocate(output.length);
//			buffer.put(output);
//			buffer.flip();
//			int numbytes=binChannel.write(buffer);
//			System.out.println(numbytes);
//			
//			ByteBuffer intbuffer=ByteBuffer.allocate(Integer.BYTES);
//			intbuffer.putInt(245);
//			intbuffer.flip();
//			numbytes=binChannel.write(intbuffer);
//			System.out.println(numbytes);
//			
//			intbuffer.flip();
//			intbuffer.putInt(-98765);
//			intbuffer.flip();
//			numbytes=binChannel.write(intbuffer);
//			System.out.println(numbytes);
//	*/		
//			/*RandomAccessFile ra= new RandomAccessFile("data.dat","rwd");
//			byte[] b=new byte[output.length];
//			ra.read(b);
//			System.out.println(new String(b));
//			long int1=ra.readInt();
//			long int2=ra.readInt();
//			System.out.println(int1);
//			System.out.println(int2);*/  //using JAVA.IO
//			
//			//JAVA.NIO
//	/*		RandomAccessFile ra= new RandomAccessFile("data.dat", "rwd");
//			FileChannel channel=ra.getChannel();
//			output[0]='a';
//			output[1]='b';
//			buffer.flip();
//			long numBytesRead=channel.read(buffer);
//			if(buffer.hasArray()) {
//				System.out.println("byte buffer = "+new String(buffer.array()));
//				//System.out.println("byte buffer = "+new String(output) );
//			}
//			
//			//absolute read
//			intbuffer.flip();
//			numBytesRead=channel.read(intbuffer);
//			System.out.println(intbuffer.getInt(0));
//			intbuffer.flip();
//			numBytesRead=channel.read(intbuffer);
//			intbuffer.flip();
//			System.out.println(intbuffer.getInt(0)); //absolute read
//			System.out.println(intbuffer.getInt()); //relative read
//			channel.close();
//			ra.close();
//	*/		
//			//relative read
//			/*
//			intbuffer.flip();
//			numBytesRead=channel.read(intbuffer);
//			intbuffer.flip();
//			System.out.println(intbuffer.getInt());
//			intbuffer.flip();
//			numBytesRead=channel.read(intbuffer);
//			intbuffer.flip();
//			System.out.println(intbuffer.getInt());
//			channel.close();
//			ra.close();*/
//			//System.out.println("output bytes = "+new String(output));
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
	}
}
