package multicast.converter;


import multicast.message.BaseMessage;
import multicast.message.IntroduceRequest;
import multicast.message.IntroduceResponce;
import multicast.message.MessageType;
import multicast.network.UdpPacket;

public class MessageConverter {
    public BaseMessage deserialize(UdpPacket data) {
        switch (data.getType()) {
            case IntroduceRequest:
                break;
            case IntroduceResponse:
                break;
        }

        return null;
    }

    public UdpPacket serialize(BaseMessage message) {
        MessageType msgType;
        // Check type and assign to byte
        if (message instanceof IntroduceRequest) {
            msgType = MessageType.IntroduceRequest;
        } else if (message instanceof IntroduceResponce) {
            msgType = MessageType.IntroduceResponse;
        }

        // convert message to json
        // convert json to byte array

        // check message byte array length

        // return new UdpPacket(msgType,);
        return new UdpPacket();
    }
}
