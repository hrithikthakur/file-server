import java.util.concurrent.*;

/* Do not change this class */
class Message {
    final String text;
    final String from;
    final String to;

    Message(String from, String to, String text) {
        this.text = text;
        this.from = from;
        this.to = to;
    }
}

/* Do not change this interface */
interface AsyncMessageSender {
    void sendMessages(Message[] messages);
    void stop();
}

class AsyncMessageSenderImpl implements AsyncMessageSender {
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private final int repeatFactor;

    public AsyncMessageSenderImpl(int repeatFactor) {
        this.repeatFactor = repeatFactor;
    }

    @Override
    public void sendMessages(Message[] messages) {
        for (Message msg : messages) {
            // TODO repeat messages
            for (int i = 1; i <= repeatFactor; i++) {
                executor.submit(() -> {
                            try {
                                System.out.printf("(%s>%s): %s\n", msg.from, msg.to, msg.text); // do not change it
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                );
            }
        }
    }

    @Override
    public void stop() {
        // TODO stop the executor and wait for its termination
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}