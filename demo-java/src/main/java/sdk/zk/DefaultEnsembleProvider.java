package sdk.zk;

import org.apache.curator.ensemble.EnsembleProvider;

import java.io.IOException;

public class DefaultEnsembleProvider implements EnsembleProvider {

    private final String serverList;

    public DefaultEnsembleProvider (String serverList){
        this.serverList = serverList;
    }
    @Override
    public void start() throws Exception {

    }

    @Override
    public String getConnectionString() {
        return serverList;
    }

    @Override
    public void close() throws IOException {

    }

    public void setConnectionString(String s) {

    }

    public boolean updateServerListEnabled() {
        return false;
    }
}
