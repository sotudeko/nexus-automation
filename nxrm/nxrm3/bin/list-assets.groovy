import org.sonatype.nexus.repository.storage.Asset
import org.sonatype.nexus.repository.storage.Query
import org.sonatype.nexus.repository.storage.StorageFacet
import java.text.SimpleDateFormat

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

// def request = new JsonSlurper().parseText(args)
def repoName = 'staging-development'

def date = new Date()
def startDate = new SimpleDateFormat("yyyy-MM-dd")
startDate = startDate.format(date)

log.info("Gathering Asset list for repository: ${repoName} as of startDate: ${startDate}")

def repo = repository.repositoryManager.get(repoName)
StorageFacet storageFacet = repo.facet(StorageFacet)
def tx = storageFacet.txSupplier().get()

outputFilename = "/var/tmp/assetlist-" + "${startDate}" + ".txt"
File outFile = new File(outputFilename)
 
tx.begin()
Iterable<Asset> assets = tx.findAssets(Query.builder().where('last_updated > ').param(startDate).build(), [repo])
assets.each { 
        def asset = "/${repoName}/${it.name()} ${it.size()}b ${it.createdBy()} ${it.lastUpdated()}"
        log.info("${asset}")
        outFile << "${asset}" + "\n"
}
tx.commit()    

return



