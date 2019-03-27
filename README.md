# Find Cluster Manager 

## Description
A simple module that identifies which instance is the Cluster Leader, you can use this to implement your own custom logic that only runs on 1 server.

In your logic use the rule: "ClusterLeader.IsCurrentInstanceClusterLeader" to identify if you are running as cluster leader. This microflow returns a boolean that indicates if this logic is executed at the cluster leader.

This module works by adding the before startup and before shutdown microflows, after that module will check every 5 minutes for an active cluster leader and if an instance crashes unexpectedly it will correct this at most within 15 minutes. 