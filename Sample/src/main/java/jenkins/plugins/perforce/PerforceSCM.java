package jenkins.plugins.perforce;

import java.io.File;
import java.io.IOException;

import org.kohsuke.stapler.DataBoundConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hudson.FilePath;
import hudson.Launcher;
import hudson.Util;
import hudson.model.Job;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.scm.ChangeLogParser;
import hudson.scm.PollingResult;
import hudson.scm.SCM;
import hudson.scm.SCMRevisionState;

public class PerforceSCM extends SCM {
    
    @Override
    public PollingResult compareRemoteRevisionWith(Job<?, ?> project,
            Launcher launcher, FilePath workspace, TaskListener listener,
            SCMRevisionState baseline)
                    throws IOException, InterruptedException {
        
        return super.compareRemoteRevisionWith(project, launcher, workspace, listener,
                baseline);
    }


    @Override
    public SCMRevisionState calcRevisionsFromBuild(Run<?, ?> build,
            FilePath workspace, Launcher launcher, TaskListener listener)
                    throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        return super.calcRevisionsFromBuild(build, workspace, launcher, listener);
    }

    @Override
    public void checkout(Run<?, ?> build, Launcher launcher, FilePath workspace,
            TaskListener listener, File changelogFile,
            SCMRevisionState baseline)
                    throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        super.checkout(build, launcher, workspace, listener, changelogFile, baseline);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(PerforceSCM.class);  
    
    String p4User;
    String p4Passwd;
    String p4Port;
    
    @DataBoundConstructor
    public PerforceSCM(
            String p4User,
            String p4Passwd,
            String p4Port
            ) {
        
        this.p4User = Util.fixEmptyAndTrim(p4User);
        this.p4Passwd = p4Passwd;
        this.p4Port = p4Port;
    }

    public String getP4User() {
        return p4User;
    }
    

    public String getP4Passwd() {
        return p4Passwd;
    }
    

    public String getP4Port() {
        return p4Port;
    }
    

    @Override
    public ChangeLogParser createChangeLogParser() {
        // TODO Auto-generated method stub
        return new PerforceChangeLogParser();
    }

}
