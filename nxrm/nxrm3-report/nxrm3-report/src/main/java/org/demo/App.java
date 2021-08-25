package org.demo;

import org.sonatype.nexus.common.app.ApplicationDirectories;
import org.sonatype.nexus.repository.*;
import org.sonatype.nexus.repository.config.Configuration;


public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        Repository repo = null;

        String r = repo.getName();

        System.out.println(r);

        System.out.println(repo.toString());


    }
}
