package multicast.network;

import lombok.*;
import multicast.message.MessageType;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UdpPacket {
	private MessageType type;
	private int length;
	private byte[] value;
}
